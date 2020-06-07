import weka.classifiers.trees.RandomForest;
import weka.classifiers.evaluation.*;
import weka.core.Instances;
public class RForest extends Thread{
	Instances Train;
	Instances Test;
	public RForest(Instances Train, Instances Test){
		this.Train = Train;
		this.Test = Test;
	}
	@Override
	public void run(){
		RandomForest modelo = new RandomForest();
		try {
			modelo.buildClassifier(this.Train);
			Evaluation eval = new Evaluation(this.Test);
			eval.evaluateModel(modelo, this.Test);
			System.out.println("-----------Random Forest---------------");
			System.out.println(eval.toSummaryString());
			System.out.println("---------------------------------------");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
