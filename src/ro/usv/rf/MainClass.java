package ro.usv.rf;

public class MainClass {

	public static void main(String[] args) {
		double[][] learningSet = null;
		try {
			learningSet = FileUtils.readLearningSetFromFile("in.txt");
			int numberOfPatterns = learningSet.length;
			int numberOfFeatures = learningSet[0].length;
			System.out.println(String.format("The learning set has %s patters and %s features", numberOfPatterns,
					numberOfFeatures));
		} catch (USVInputFileCustomException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Finished learning set operations");
		}

		double[] euclidianDistances = DistanceUtils.calculateEuclidianDistances(learningSet[0], learningSet[1]);
		double[] mDistances = new double[learningSet.length];
		double[] cebisevDistances = new double[learningSet.length];
		double[] cBDistances = new double[learningSet.length];

		for (int i = 0; i < learningSet.length - 1; ++i) {
			mDistances[i] = DistanceUtils.calculateMahalanobisDistances(learningSet[i], learningSet[i + 1],
					learningSet.length);

			cebisevDistances[i] = DistanceUtils.calculateCebisevDistances(learningSet[i], learningSet[i + 1]);

			cBDistances[i] = DistanceUtils.calculateCityBlockDistances(learningSet[i], learningSet[i + 1]);

			System.out.println(cBDistances[i]);
		}

	}
}