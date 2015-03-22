package me.geso.yoki;

@FunctionalInterface
public interface ThrowableRunnable {
	@SuppressWarnings("RedundantThrows")
	public void run() throws Exception;
}
