package workshop.music.entity;

public class MP3 extends DigitalMedia implements Playable {
    private int fileSize; //파일 크기
    private int volume; //볼륨

    public MP3(String title, String artist, String format, int fileSize) {
        super(title, artist, format);
        this.fileSize = fileSize;
        this.volume = 5;
    }

    public MP3(String title, String artist) {
        this(title, artist, "MP3", 5);
    }

    //재생
    @Override
    public void play() {
        System.out.println("MP3 형식의 '" + title + "'이(가) 디지털로 재생됩니다.");
        System.out.println("현재 볼륨: " + volume);
    }

    //정보 출력
    @Override
    public void displayInfo() {
        System.out.println("제목: " + title + ", 아티스트: " + artist);
        System.out.println("포맷: " + format);
        System.out.println("파일 크기: " + fileSize + "MB");
    }

    //볼륨 설정
    @Override
    public void setVolume(int level) {
        this.volume = level;
        System.out.println("볼륨이 " + volume + "로 설정되었습니다.");
    }

    //재생 중지
    @Override
    public void stop() {
        System.out.println("MP3 재생이 중지되었습니다.");
    }
}