package version.eight.stream.optional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OptionalFeatureMain {

  private Employee emp;

  Map<Integer, Employee> employeeMap = new HashMap<>();

  Optional<Employee> optionalEmployee = getEmployee(100);
  if(optionalEmployee.isPresent())

  {
    System.out.println(optionalEmployee.get.getName());
  }

  public Optional<Employee> getEmployee(Integer empId) {
    return Optional.ofNullable(employeeMap.get(empId));
  }

}


