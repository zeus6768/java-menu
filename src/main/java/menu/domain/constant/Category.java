package menu.domain.constant;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public enum Category {
    NONE("", List.of()),
    ASIAN("아시안", List.of("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")),
    CHINESE("중식", List.of("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")),
    JAPANESE("일식", List.of("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")),
    KOREAN("한식", List.of("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")),
    WESTERN("양식", List.of("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));

    private final String name;
    private final List<String> menus;

    Category(String name, List<String> menus) {
        this.name = name;
        this.menus = menus;
    }

    public static Category getRandomCategory() {
        return values()[Randoms.pickNumberInRange(1, 5)];
    }

    public static String getRandomMenu(Category category) {
        List<String> menus = category.getMenus();
        return Randoms.shuffle(menus).get(0);
    }

    public String getName() {
        return name;
    }

    public List<String> getMenus() {
        return menus;
    }
}
