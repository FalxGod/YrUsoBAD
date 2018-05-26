package onion.falxgod.yrusobad.handlers;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import onion.falxgod.yrusobad.threading.UnitLoadCallable;
import onion.falxgod.yrusobad.unit.Unit;

public class UnitLoadHandler {
	private ExecutorService executorService;
	private List<Future<Unit>> futurList;
	
	public UnitLoadHandler() {
		futurList = new ArrayList<>();
		executorService = Executors.newCachedThreadPool();
		futurList = Collections.synchronizedList(new ArrayList<>());
	}
	
	public void load() {
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get("data", "units"), "*.unit")) {
			stream.forEach(f -> {
				futurList.add(executorService.submit(new UnitLoadCallable(f)));
			});
	     } catch (IOException e) {
			e.printStackTrace();
		}
	}
}
