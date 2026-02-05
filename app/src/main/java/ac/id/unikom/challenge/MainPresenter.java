package ac.id.unikom.challenge;

public class MainPresenter {

    private MainView view;
    private Meter model;

    public MainPresenter(MainView view) {
        this.view = view;
        this.model = new Meter();
    }

    public void calculateLength() {

        String meterInput = view.getMeter();

        if (meterInput == null || meterInput.isEmpty()) {
            meterInput = "0";
        }

        try {
            double value = Double.parseDouble(meterInput);

            model.setMeter(value);

            String km = String.valueOf(model.toKilometer());
            String cm = String.valueOf(model.toCentimeter());

            view.showKilometer(km);
            view.showCentimeter(cm);

        } catch (NumberFormatException e) {
            view.showKilometer("0");
            view.showCentimeter("0");
        }
    }

    public void onDestroy() {
        view = null;
    }
}
