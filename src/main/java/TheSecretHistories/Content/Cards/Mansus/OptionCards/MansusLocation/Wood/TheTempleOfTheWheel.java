package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.Wood;

import TheSecretHistories.Content.Cards.FITIF.Fragments.FragmentSecretHistories;
import TheSecretHistories.Content.Cards.FITIF.Influences.InfluenceHeart;
import TheSecretHistories.Content.Cards.FITIF.Influences.InfluenceKnock;
import TheSecretHistories.Content.Cards.FITIF.Influences.InfluenceMoth;
import TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.AbstractMansusLocation;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.cards.AbstractCard;

public class TheTempleOfTheWheel extends AbstractMansusLocation {

    public static final String ID = StringUtils.MakeID(TheTempleOfTheWheel.class.getSimpleName());

    private static final String IMG_NAME = "waywood";
    private static final AbstractCard[] CARDS = new AbstractCard[]{
            new InfluenceKnock(),
            new InfluenceHeart(),
            new FragmentSecretHistories().DoUpgrade(1)
            // 古怪传闻
    };

    public TheTempleOfTheWheel(AbstractCard[] cards) {
        super(ID, IMG_NAME, CARDS);
    }
}
