package workshop.music.entity;

public class DigitalMedia extends MusicMedia {
    protected String format; //포맷

    public DigitalMedia(String title, String artist, String format) {
        super(title, artist);
        this.format = format;
    }

    //재생
    @Override
    public void play() {
        System.out.println(format + " 형식의 '" + title + "'이(가) 디지털로 재생됩니다.");
    }

    //정보 출력
    @Override
    public void displayInfo() {
        System.out.println("제목: " + title + ", 아티스트: " + artist);
        System.out.println("포맷: " + format);
    }
}