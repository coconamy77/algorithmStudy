function Music(start, end, title, notes){
    this.time = this.getTime(end)-this.getTime(start);
    this.notes = this.getNotes(notes,this.time);
    this.title = title;
}

Music.prototype = {
    getTime(time){
        return Number(time.split(":")[0]*60)+Number(time.split(":")[1]);
    },
    getNotes(note, time){
        let notes = "";
        
        while(time>note.length){
            notes += note;
            time -=note.length;
        }
        
        notes += note.substring(0,time);
        
        return notes;
    }
}

function solution(m, musicinfos) {
    var answer = null;
	let mNote = changeNote(m);

    musicinfos.forEach(function(music){
        let infos = music.split(",");
        let tmpMusic = new Music(infos[0],infos[1],infos[2],changeNote(infos[3]));
		
		if(tmpMusic.notes.includes(mNote)){
			if(answer===null){
				answer = tmpMusic;
			}else{
				if(answer.time<tmpMusic.time){
					answer = tmpMusic;
				}
			}
		}
    })
	
	if(answer===null){
		return "(None)";
	}
    return answer.title;
}

function changeNote(oriNote){
	let note = "";
	for (let i = 1; i < oriNote.length; i++) {
		let tmp = oriNote.charAt(i - 1);
		if (oriNote.charAt(i) === '#') {
			tmp = oriNote.charAt(i-1).toLowerCase();
			i++;
		}
		note += tmp;
	}
	if(oriNote.charAt(oriNote.length-1)==='#'){
        return note;
	}
	note += oriNote.charAt(oriNote.length-1);
    return note;
}