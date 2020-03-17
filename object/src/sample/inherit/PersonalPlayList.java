package sample.inherit;

public class PersonalPlayList {
    private Playlist playList = new Playlist();

    public void append(Song song){
        playList.append(song);
    }

    public void remove(Song song){
        playList.getTracks().remove(song);
        playList.getSingers().remove(song.getSinger());
    }
}
