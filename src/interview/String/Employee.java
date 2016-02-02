package interview.String;

import java.util.HashSet;
import java.util.Set;

public class Employee {
	//hashcode equal
	//hashcode是用来查找的，实现的问题是将类存储在内存中对应的位置上
	//假如两个类具有相同的hashcode，如何找到对应点类呢？先通过hashcode找到桶，然后通过equal找到对应的类
	//会不会出现hashcode相同，但equal的情况？会，没有重写equal方法，
	//会不会出现equal相同，但hashcode不同的情况？会，没有重写hashcode方法。
	//equal是用来比较两个对象，hashcode是用来查找某个对象
	private Integer id;
	private String firstName;
	private String lastName;
	private String department;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	public static void main(String[] args){
		Employee e1 = new Employee();
		Employee e2 = new Employee();
		System.out.println(e1 == e2);
		System.out.println(e1.equals(e2));
		
		Set<Employee> employees = new HashSet<Employee>();
		employees.add(e1);
		employees.add(e2);
		System.out.println(employees);
		
		
	}
}
