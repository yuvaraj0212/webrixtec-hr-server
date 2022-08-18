package webrix.hr.pojo;

public class duplicationRequest {
	private long dup_id;
	private String duplication_status;
	private String duplication_msg;

	public long getDup_id() {
		return dup_id;
	}

	public void setDup_id(long dup_id) {
		this.dup_id = dup_id;
	}

	public String getDuplication_status() {
		return duplication_status;
	}

	public void setDuplication_status(String duplication_status) {
		this.duplication_status = duplication_status;
	}

	public String getDuplication_msg() {
		return duplication_msg;
	}

	public void setDuplication_msg(String duplication_msg) {
		this.duplication_msg = duplication_msg;
	}

	public duplicationRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

}
