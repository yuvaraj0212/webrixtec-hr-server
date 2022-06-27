package webrixtec.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.logging.log4j.util.Supplier;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import webrixtec.model.resumeModel;
import webrixtec.repo.resumeRepo;
import webrixtec.utils.components;

@Service
public class resumeSrevice {
	@Autowired
	components uploadstream;
	@Autowired
	resumeRepo resRepo;

	public List<Map<String, String>> addexcelsheet(MultipartFile excel) throws IOException {
		Path tempdir = Files.createTempDirectory("");
		File tempFile = tempdir.resolve(excel.getOriginalFilename()).toFile();
		excel.transferTo(tempFile);
		Workbook workbook = WorkbookFactory.create(tempFile);
		Sheet sheet = workbook.getSheetAt(0);
		Supplier<Stream<Row>> rowstream = uploadstream.getRowStreamSupplier(sheet);
		Row headerRow = rowstream.get().findFirst().get();
		List<String> headerCells = uploadstream.getStreams(headerRow).map(cell -> {
			if (cell.getCellType() == org.apache.poi.ss.usermodel.CellType.STRING) {
				return cell.getStringCellValue();
			} else if (cell.getCellType() == org.apache.poi.ss.usermodel.CellType.NUMERIC
					|| cell.getCellType() == org.apache.poi.ss.usermodel.CellType.FORMULA) {
				String strValue = String.valueOf(cell.getNumericCellValue());
				return strValue;
			} else if (cell.getCellType() == org.apache.poi.ss.usermodel.CellType.BLANK) {
				return "";
			} else {
				return String.valueOf(cell.getBooleanCellValue());
			}

		}).collect(Collectors.toList());

		int colCount = headerCells.size();
		System.out.println(colCount +" :colCount");
		List<Map<String, String>> values = rowstream.get().skip(1).map(row -> {
			System.out.println("0");
			List<String> cellList = uploadstream.getStreams(row).map(cell -> {
				if (cell.getCellType() == org.apache.poi.ss.usermodel.CellType.STRING) {
					System.out.println("2"+cell);
					return cell.getStringCellValue();
				}
				else if (cell.getCellType() == org.apache.poi.ss.usermodel.CellType.NUMERIC
						|| cell.getCellType() == org.apache.poi.ss.usermodel.CellType.FORMULA) {
					String strValue = String.valueOf(cell.getNumericCellValue());
					if (DateUtil.isCellDateFormatted(cell)) {
						DateFormat dt = new SimpleDateFormat("dd/MM/yy");
						Date date = cell.getDateCellValue();
						strValue = dt.format(date);
					}
					System.out.println("3"+cell);
					return strValue;
				} else if (cell.getCellType() == org.apache.poi.ss.usermodel.CellType.BLANK) {
					System.out.println("4"+cell);
					return "";
				} 
				else {
					System.out.println("5"+cell);
					return String.valueOf(cell.getBooleanCellValue());
				}
			}).collect(Collectors.toList());
			return uploadstream.cellinteratorSupplier(colCount).get()
					.collect(Collectors.toMap(headerCells::get, cellList::get));
		}).collect(Collectors.toList());
		int valueLength = values.size();
		for (int i = 0; i < valueLength; i++) {
			resumeModel obj = new resumeModel();
//			obj.setDate(values.get(i).get("date"));
//			obj.setStatus(values.get(i).get("Status"));
			
			obj.setJapanese(values.get(i).get("Japanese"));
			obj.setContractDetails(values.get(i).get("Contract details"));
			obj.setPositions(values.get(i).get("Positions"));
			obj.setIndustry(values.get(i).get("Industry"));
			obj.setJobDescription(values.get(i).get("Job Description"));
			obj.setLanguage(values.get(i).get("Language"));
			obj.setLocation(values.get(i).get("Location"));
			obj.setMaximumSalary(values.get(i).get("Maximum Salary"));
			obj.setMinimumSalary(values.get(i).get("Minimum Salary"));
			obj.setPositionHNO(values.get(i).get("Position/HNO"));
			obj.setPositionType(values.get(i).get("Position Type"));
			obj.setRequirements(values.get(i).get("Requirements"));
			obj.setResiding(values.get(i).get("Residing"));
			obj.setSino(values.get(i).get("SI.NO"));
			resRepo.saveAll(List.of(obj));
		}
		workbook.close();
		return values;
	}

	public List<resumeModel> getresume() {
		List<resumeModel> obj = resRepo.findAll();
		return obj;
	}

}
