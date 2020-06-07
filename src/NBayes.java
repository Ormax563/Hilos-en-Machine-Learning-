import weka.core.Instances;
import weka.classifiers.bayes.*;
import weka.classifiers.evaluation.Evaluation;
public class NBayes extends Thread{
	Instances Train;
	Instances Test;
	public NBayes(Instances Train, Instances Test){
		this.Train = Train;
		this.Test = Test;
	}
	@Override
	public void run(){
		NaiveBayes modelo = new NaiveBayes();
		try {
			modelo.buildClassifier(this.Train);
			Evaluation eval = new Evaluation(this.Test);
			eval.evaluateModel(modelo, this.Test);
			System.out.println("-----------Naive Bayes---------------");
			System.out.println(eval.toSummaryString());
			System.out.println("---------------------------------------");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
