function Music(start, end, title, notes){
    this.time = getTime(end)-getTime(start);
    this.notes = getNotes(notes,this.time);
    this.title = title;
    console.log(notes)
}

Music.prototype = {
    getTime(time){
        return time.split(":")[0]*60+time.split(":")[1];
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
    var answer = '';
    musicinfos.forEach(function(music){
        let infos = music.split(",");
        let m = new Music(infos[0],infos[1],infos[2],infos[3]);
    })
    return answer;
}