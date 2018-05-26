package onion.falxgod.yrusobad.threading;

import java.nio.file.Path;
import java.util.concurrent.Callable;

import onion.falxgod.yrusobad.unit.Unit;

public class UnitLoadCallable implements Callable<Unit> {
	private Path filePath;

	public UnitLoadCallable(Path filePath) {
		this.filePath = filePath;
	}

	@Override
	public Unit call() throws Exception {
		return null;
	}

}
