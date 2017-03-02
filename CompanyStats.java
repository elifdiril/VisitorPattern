import java.util.ArrayList;

/**
* A visitor that prints the company stats.
*/
public class CompanyStats implements IVisitor {
	ArrayList<String> emp= new ArrayList<String>();
	ArrayList<String> bos = new ArrayList<String>();
	ArrayList<String> dep = new ArrayList<String>();
	ArrayList<String> semp = new ArrayList<String>();
	ArrayList<Integer> bosemp = new ArrayList<Integer>();
	ArrayList<Integer> bossemp = new ArrayList<Integer>();
	ArrayList<String> sempb = new ArrayList<String>();
	ArrayList<Double> infScore = new ArrayList<Double>();
		
	int tabCount = 0;		
		public void visit(Employee employee) {			
			emp.add(employee.name().toString());			
			}
		public void visit(Dept dept) {			
			dep.add(dept.name().toString());			
			dept.visitUnits(this);			
		}
		public void visit(Boss boss) {		
			bos.add(boss.name().toString());
			bosemp.add(boss.employees().size());
			for(int i=0;i<bos.size();i++){
				
			}			
			boss.visitEmployees(this);
			for(int i=0;i<boss.employees().size();i++){
				if(boss.employees().get(i).toString().contains("Senior"))
					sempb.add(boss.name());
			}
			
				}
			
		public void visit(SeniorEmployee semployee) {	
			semp.add(semployee.name().toString());	
			
		}		
		public void printResult() {
			int d=0;
			for (int i=0;i<bos.size();i++){
				d=0;
				for(int k=0;k<sempb.size();k++){
					if(sempb.get(k).contains(bos.get(i)))
					d++;	
					
				}
				bossemp.add(d);
			}
			
			for(int i=0;i<bos.size();i++){
				infScore.add((bosemp.get(i)-bossemp.get(i))+(1.2*bossemp.get(i)));			
			}
			double max=0;
			int maxInd=0;
			for(int i=0;i<infScore.size();i++){
				if(max<infScore.get(i)){
					max=infScore.get(i);
					maxInd=i;
				}
			}			
			
			System.out.println("Departments:" + dep.size());
			System.out.println("Bosses: " + bos.size());
			System.out.println("Employees: " + emp.size());
			System.out.println("SeniorEmployees: " + semp.size());
			System.out.println("Most influential boss: " ); 
			System.out.println("\t "+ "Name : "+bos.get(maxInd));
			System.out.println("\t "+ "Total Employees: "+bosemp.get(maxInd));
			System.out.println("\t "+"Influence Score: "+infScore.get(maxInd));		
			
		}
	}
