package sample.inherit;

public class PersonalPlayList extends Playlist{
    public void remove(Song song){
        getTracks().remove(song);
        getSingers().remove(song.getSinger());
    }
}
