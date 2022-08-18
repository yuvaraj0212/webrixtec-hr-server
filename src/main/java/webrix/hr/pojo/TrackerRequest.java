package webrix.hr.pojo;

public class TrackerRequest {
	private long tracker_id;
	private String trackStaus;
	private String track_msg;

	public long getTracker_id() {
		return tracker_id;
	}

	public void setTracker_id(long tracker_id) {
		this.tracker_id = tracker_id;
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

}
