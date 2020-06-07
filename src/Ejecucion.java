import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.gui.beans.TrainTestSplitMaker;
import java.util.Random;
public class Ejecucion {
public static void main(String[] args) throws Exception{
		
		DataSource dataset = new DataSource("C:/Users/Usuario/Downloads/iris.csv");
		Instances data = dataset.getDataSet();
		data.setClassIndex(data.numAttributes() - 1);
		data.randomize(new Random(100));
		int tamTrain = (int) Math.round(150*0.7);
		int tamTest = 150 - tamTrain;
		Instances Train = new Instances(data, 0, tamTrain);
		Instances Test = new Instances(data, tamTrain, tamTest-1);
		RForest tarea1 = new RForest(Train,Test);
		NBayes tarea2 = new NBayes(Train,Test);
		tarea1.start();
		tarea2.start();
		
	}
}
