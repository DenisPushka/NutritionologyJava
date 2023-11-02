package nutritionology.services.implementers;

import nutritionology.models.dictionaries.BiologicalElement;
import nutritionology.models.dictionaries.MR;
import nutritionology.models.dictionaries.MRItem;
import nutritionology.models.dictionaries.MS;
import nutritionology.services.interfaces.MRServiceInterface;

public class MRService implements MRServiceInterface {
    @Override
    public MS[] AddMs(MS ms) {
        return new MS[0];
    }

    @Override
    public MS[] AddArrayMs(MS[] mses) {
        return new MS[0];
    }

    @Override
    public MS[] GetMSes() {
        return new MS[0];
    }

    @Override
    public BiologicalElement[] GetBiologicallyElements() {
        return new BiologicalElement[0];
    }

    @Override
    public MRItem[] AddMrItem(MRItem mrItem) {
        return new MRItem[0];
    }

    @Override
    public MRItem[] AddArrayMrItems(MRItem[] mrItems) {
        return new MRItem[0];
    }

    @Override
    public MRItem[] UpdateMrItem(MRItem mrItem) {
        return new MRItem[0];
    }

    @Override
    public MRItem[] GetAllMrItems() {
        return new MRItem[0];
    }

    @Override
    public MR[] AddMr(MR mr) {
        return new MR[0];
    }

    @Override
    public MR[] AddMrs(MR[] mrs) {
        return new MR[0];
    }

    @Override
    public MR[] UpdateMr(MR mr) {
        return new MR[0];
    }

    @Override
    public MR[] GetAllMr() {
        return new MR[0];
    }
}
