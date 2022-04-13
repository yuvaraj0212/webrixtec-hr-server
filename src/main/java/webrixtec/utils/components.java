package webrixtec.utils;

import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.apache.logging.log4j.util.Supplier;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Component;

@Component
public class components {
	
	public Supplier<Stream<Row>> getRowStreamSupplier(Iterable<Row> rows) {
		return ()->getStreams(rows);
	}
	
	public <T>Stream<T> getStreams(Iterable<T> itreables) {
		return StreamSupport.stream(itreables.spliterator(), false);
	}
	
	public Supplier<Stream<Integer>> cellinteratorSupplier(int num ) {
		return ()->numberStreams(num);
	}
	
	public Stream<Integer> numberStreams(int num) {
		return IntStream.range(0, num).boxed();	
	}
	
}
