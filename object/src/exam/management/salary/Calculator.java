package exam.management.salary;

/*
직원 급여를 계산한다
        사용자로부터 소득세율을 입력받는다
        (입력) 세율 입력하세요 :
        키보드를 통해 입력받는다
        직원의 급여를 계산한다
        전역 변수에 저장된 직원의 기본급 정보를 얻는다
        급여를 계산한다
        양식에 맞게 결과를 출력한다
        이름 {직원명] 급여 {계산된 금액} ㄹ형식에 따라 ㅁ출력 문자열을 출력한다
        */
public class Calculator {
    public int calculatePostTaxAnnualSalary(double taxRate, double salary) {
        double tax = salary * (taxRate/100);
        double postTaxMonthSalary = salary - tax;
        double postTaxAnnualSalary = postTaxMonthSalary * 12;
        return Integer.parseInt(String.valueOf(Math.round(postTaxAnnualSalary)));
    }
}
