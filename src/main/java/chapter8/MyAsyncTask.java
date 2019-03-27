package chapter8;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.ServletResponse;

public class MyAsyncTask implements Runnable{

	private AsyncContext context;

	public MyAsyncTask(AsyncContext context) {
		this.context = context;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(3000);
			ServletResponse resp = context.getResponse();
			resp.getWriter().write("Hello from Async Task");
			resp.flushBuffer();
			context.complete();
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
