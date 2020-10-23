package JavaThursday;

public class StringBuilderDemo {
	
	
	public static void main(String[] args) {


		String s="hello hi good morning I am enjoying programming with java";
		StringBuilder sb=new StringBuilder(s);
		
		/* using one string builder */
		s = sb.reverse().toString();
		sb.setLength(0);
		
		/* using two string builders */
//		StringBuilder sb2=new StringBuilder(s);
//		s = sb2.reverse().toString();
		
		String ar[]=s.split(" ");
		for(String s1:ar) {
			sb.append(Character.toUpperCase(s1.charAt(0))).append(s1.substring(1)).append(" ");
		}
		System.out.println(sb./* second reverse */reverse().toString().trim());
		
		

	}

}
