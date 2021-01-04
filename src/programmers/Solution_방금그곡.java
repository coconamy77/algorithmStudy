package programmers;

class Music {
	int time;
	String notes;
	String title;

	public Music(String start, String end, String title, String notes) {
		this.time = getTime(end) - getTime(start);
		this.title = title;
		this.notes = getNotes(notes, this.time);
		System.out.println(this.notes);
	}

	public int getTime(String time) {
		return Integer.parseInt(time.split(":")[0]) * 60 + Integer.parseInt(time.split(":")[1]);
	}

	public String getNotes(String note, int curTime) {
		StringBuilder sb = new StringBuilder();
		while (curTime > note.length()) {
			sb.append(note);
			curTime -= note.length();
		}

		sb.append(note.substring(0, curTime));

		return sb.toString();
	}

}

public class Solution_방금그곡 {
	public String changeNote(String originalNote) {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < originalNote.length(); i++) {
			char tmp = originalNote.charAt(i - 1);
			if (originalNote.charAt(i) == '#') {
				sb.append(Character.toString(tmp + 32));
				i++;
			} else {
				sb.append(tmp);
			}
		}
		sb.append(originalNote.charAt(originalNote.length() - 1));
		return sb.toString();
	}

	public String solution(String m, String[] musicinfos) {
		m = changeNote(m);
		Music answer = null;

		Music music;
		for (String musicInfo : musicinfos) {
			String[] info = musicInfo.split(",");
			music = new Music(info[0], info[1], info[2], changeNote(info[3]));
			if (music.notes.contains(m)) {
				if (answer == null) {
					answer = music;
				} else {
					if (answer.time < music.time) {
						answer = music;
					}
				}
			}
		}
		if (answer == null) {
			return "(None)";
		}
		return answer.title;
	}
}
