package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.Spider;

import TheSecretHistories.Content.Cards.FITIF.Fragments.FragmentSecretHistories;
import TheSecretHistories.Content.Cards.FITIF.Influences.InfluenceForge;
import TheSecretHistories.Content.Cards.FITIF.Influences.InfluenceLantern;
import TheSecretHistories.Content.Cards.FITIF.Ingredients.Forge.IngredientForgeF;
import TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.AbstractHiddenLocation;
import TheSecretHistories.Content.Cards.Others.Favour;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.cards.AbstractCard;

public class TheMalleary extends AbstractHiddenLocation {

    public static final String ID = StringUtils.MakeID(TheMalleary.class.getSimpleName());

    private static final String IMG_NAME = "wayspider";
    private static final AbstractCard[] CARDS = new AbstractCard[]{
            new InfluenceForge().DoUpgrade(3),
            new InfluenceLantern().DoUpgrade(2),
            new IngredientForgeF(),
            new FragmentSecretHistories().DoUpgrade(4),
            // new Favour(),
    };

    public TheMalleary() {
        super(ID, IMG_NAME, CARDS);
    }
}
