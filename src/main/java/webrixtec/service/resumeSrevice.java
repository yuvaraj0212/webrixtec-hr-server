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

		List<Map<String, String>> values = rowstream.get().skip(1).map(row -> {
			List<String> cellList = uploadstream.getStreams(row).map(cell -> {
				if (cell.getCellType() == org.apache.poi.ss.usermodel.CellType.STRING) {
					return cell.getStringCellValue();
				} else if (cell.getCellType() == org.apache.poi.ss.usermodel.CellType.NUMERIC
						|| cell.getCellType() == org.apache.poi.ss.usermodel.CellType.FORMULA) {
					String strValue = String.valueOf(cell.getNumericCellValue());
					if (DateUtil.isCellDateFormatted(cell)) {
						DateFormat dt = new SimpleDateFormat("dd/MM/yy");
						Date date = cell.getDateCellValue();
						strValue = dt.format(date);
					}
					return strValue;
				} else if (cell.getCellType() == org.apache.poi.ss.usermodel.CellType.BLANK) {
					return "";
				} else {
					return String.valueOf(cell.getBooleanCellValue());
				}
			}).collect(Collectors.toList());
			return uploadstream.cellinteratorSupplier(colCount).get()
					.collect(Collectors.toMap(headerCells::get, cellList::get));
		}).collect(Collectors.toList());
		int valueLength = values.size();
		for (int i = 0; i < valueLength; i++) {
			String Status = values.get(i).get("Status");
			String date = values.get(i).get("Date");
			resumeModel obj = new resumeModel();
			obj.setStatus(Status);
			obj.setDate(date);
			resRepo.saveAll(List.of(obj));
		}
		return values;
	}

	public List<resumeModel> getresume() {
		List<resumeModel> obj = resRepo.findAll();
		return obj;
	}

}
