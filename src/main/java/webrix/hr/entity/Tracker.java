package webrix.hr.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "trcker_tbl")
public class Tracker {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String trackStaus;
	private String track_msg;
	private Date createDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTrackStaus() {
		return trackStaus;
	}

	public void setTrackStaus(String trackStaus) {
		this.trackStaus = trackStaus;
	}

	public String getTrack_msg() {
		return track_msg;
	}

	public void setTrack_msg(String track_msg) {
		this.track_msg = track_msg;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
