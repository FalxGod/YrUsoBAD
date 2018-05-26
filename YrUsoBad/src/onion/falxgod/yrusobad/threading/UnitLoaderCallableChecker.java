package onion.falxgod.yrusobad.threading;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

import onion.falxgod.yrusobad.unit.Unit;

public class UnitLoaderCallableChecker implements Callable<Boolean>{
	private List<Future<Unit>> futureList;
	
	public UnitLoaderCallableChecker(List<Future<Unit>> futureList) {
		this.futureList = futureList;
	}
	
	@Override
	public Boolean call() throws Exception {
		synchronized (futureList) {
			while(futureList.stream().allMatch(v -> v.isDone()) != true) {
				Thread.sleep(512);
			}
		}
		return true;
	}

}
