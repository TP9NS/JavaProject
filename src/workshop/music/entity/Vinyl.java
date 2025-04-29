package workshop.music.entity;

public class Vinyl extends MusicMedia {
    private int rpm; //회전 속도

    public Vinyl(String title, String artist, int rpm) {
        super(title, artist);
        this.rpm = rpm;
    }

    //재생
    @Override
    public void play() {
        System.out.println("바이닐 레코드 '" + title + "'이(가) " + rpm + "rpm으로 재생됩니다.");
    }

    //정보 출력
    @Override
    public void displayInfo() {
        System.out.println("제목: " + title + ", 아티스트: " + artist);
        System.out.println("회전 속도: " + rpm + " rpm");
    }
    
    public void clean() {
        System.out.println("바이닐 레코드를 청소합니다.");
    }
}