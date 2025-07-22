public class _09_Quiz {
    public static void main(String[] args) {
        String id_number = "901232-1234567";

        // substring을 이용해서 생일 뽑기
        // substring과 삼항 연산 이용해서 M / F 인지 확인하기
        // 그래서 "생일은 ~~~ 이고, 성별은 ~~입니다."라고 출력하기

        String birth = id_number.substring(2, 6);
        String gender = (id_number.substring(7, 8).equals("1")) ? "남자" : "여자"; // == 는 주소값이 같은지! equals는 값이 같은지!

        System.out.printf("생일은 %s이고, 성별은 %s입니다.", birth, gender);
    }
}
