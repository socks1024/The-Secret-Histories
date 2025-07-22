package TheSecretHistories.Content.Cards.Rites.SummonRites;

import TheSecretHistories.Content.Cards.Rites.AbstractSummonRite;
import TheSecretHistories.Utils.StringUtils;

public class RiteFollowerConsumeIngredient extends AbstractSummonRite {

    public static final String ID = StringUtils.MakeID(RiteFollowerConsumeIngredient.class.getSimpleName());

    private static final String IMG_NAME = "ritefollowerconsumeingredient";

    public RiteFollowerConsumeIngredient() {
        super(ID, IMG_NAME);
    }
}
