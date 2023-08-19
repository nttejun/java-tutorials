package design.version.b.structural;

public class AdapterPattern {

  // Target Interface
  interface MediaPlayer {

    void play(String mediaType, String fileName);
  }

  // Adaptee Interface
  interface AdvancedMediaPlayer {

    void playVlc(String fileName);

    void playMp4(String fileName);
  }

  // Concrete Adaptee
  class VlcPlayer implements AdvancedMediaPlayer {

    @Override
    public void playVlc(String fileName) {
      System.out.println("Playing VLC file: " + fileName);
    }

    @Override
    public void playMp4(String fileName) {
      // Do nothing
    }
  }

  class Mp4Player implements AdvancedMediaPlayer {

    @Override
    public void playVlc(String fileName) {
      // Do nothing
    }

    @Override
    public void playMp4(String fileName) {
      System.out.println("Playing MP4 file: " + fileName);
    }
  }

  // Adapter
  class MediaAdapter implements MediaPlayer {

    private AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(String mediaType) {
      if (mediaType.equalsIgnoreCase("vlc")) {
        advancedMediaPlayer = new VlcPlayer();
      } else if (mediaType.equalsIgnoreCase("mp4")) {
        advancedMediaPlayer = new Mp4Player();
      }
    }

    @Override
    public void play(String mediaType, String fileName) {
      if (mediaType.equalsIgnoreCase("vlc")) {
        advancedMediaPlayer.playVlc(fileName);
      } else if (mediaType.equalsIgnoreCase("mp4")) {
        advancedMediaPlayer.playMp4(fileName);
      }
    }
  }

  // Concrete Target
  class AudioPlayer implements MediaPlayer {

    private MediaAdapter mediaAdapter;

    @Override
    public void play(String mediaType, String fileName) {
      if (mediaType.equalsIgnoreCase("mp3")) {
        System.out.println("Playing MP3 file: " + fileName);
      } else if (mediaType.equalsIgnoreCase("vlc") || mediaType.equalsIgnoreCase("mp4")) {
        mediaAdapter = new MediaAdapter(mediaType);
        mediaAdapter.play(mediaType, fileName);
      } else {
        System.out.println("Invalid media type: " + mediaType);
      }
    }
  }

  public void main() {
    MediaPlayer audioPlayer = new AudioPlayer();

    audioPlayer.play("mp3", "song.mp3");
    audioPlayer.play("vlc", "movie.vlc");
    audioPlayer.play("mp4", "video.mp4");
    audioPlayer.play("avi", "video.avi");
  }
}
