package br.com.carlos;

public class Greeting {
	public final long id;
	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	public final String content;
	
	public Greeting(long id, String content) {
		super();
		this.id = id;
		this.content = content;
	}
	
}
