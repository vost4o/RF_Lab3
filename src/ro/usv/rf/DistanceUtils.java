package ro.usv.rf;

public class DistanceUtils {

	protected static double[] calculateEuclidianDistances(double[] form1, double[] form2) {
		double[] distances = new double[form1.length];

		for (int i = 0; i < form1.length - 1; ++i) {
			double x1 = form1[i];
			double x2 = form2[i];

			double y1 = form1[i + 1];
			double y2 = form2[i + 1];

			double sqDiffX = Math.pow(x1 - x2, 2);
			double sqDiffY = Math.pow(y1 - y2, 2);

			distances[i] = Math.sqrt(sqDiffX + sqDiffY);
		}

		return distances;
	}

	protected static double calculateMahalanobisDistances(double[] form1, double[] form2, int nrOfForms) {
		double distance = 0;

		for (int i = 0; i < nrOfForms; ++i) {
			distance += Math.pow(form1[i] + form2[i], nrOfForms);
		}
		distance = Math.pow(distance, 1.0 / nrOfForms);

		return distance;
	}

	protected static double calculateCebisevDistances(double[] form1, double[] form2) {
		double distance = 0;

		for (int i = 0; i < form1.length; ++i) {
			double d = Math.abs(form1[i] - form2[i]);
			distance = Math.max(distance, d);
		}

		return distance;

	}

	protected static double calculateCityBlockDistances(double[] form1, double[] form2) {
		double distance = 0;

		for (int i = 0; i < form1.length; ++i) {
			distance += Math.abs(form1[i] - form2[i]);
		}

		return distance;
	}
}
