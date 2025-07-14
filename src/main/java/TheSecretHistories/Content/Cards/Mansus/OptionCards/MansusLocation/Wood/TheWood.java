package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.Wood;

import TheSecretHistories.Content.Cards.FITIF.Fragments.FragmentSecretHistories;
import TheSecretHistories.Content.Cards.FITIF.Influences.InfluenceGrail;
import TheSecretHistories.Content.Cards.FITIF.Influences.InfluenceHeart;
import TheSecretHistories.Content.Cards.FITIF.Influences.InfluenceMoth;
import TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.AbstractMansusLocation;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.cards.AbstractCard;

public class TheWood extends AbstractMansusLocation {

    public static final String ID = StringUtils.MakeID(TheWood.class.getSimpleName());

    private static final String IMG_NAME = "waywood";
    private static final AbstractCard[] CARDS = new AbstractCard[]{
            new InfluenceMoth(),
            new FragmentSecretHistories()
            // 古怪传闻
    };

    public TheWood() {
        super(ID, IMG_NAME, CARDS);
    }
}
