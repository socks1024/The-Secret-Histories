package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.Wood;

import TheSecretHistories.Content.Cards.FITIF.Fragments.FragmentSecretHistories;
import TheSecretHistories.Content.Cards.FITIF.Influences.InfluenceHeart;
import TheSecretHistories.Content.Cards.FITIF.Influences.InfluenceKnock;
import TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.AbstractHiddenLocation;
import TheSecretHistories.Content.Cards.Others.Rumour;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.cards.AbstractCard;

public class TheTempleOfTheWheel extends AbstractHiddenLocation {

    public static final String ID = StringUtils.MakeID(TheTempleOfTheWheel.class.getSimpleName());

    private static final String IMG_NAME = "waywood";
    private static final AbstractCard[] CARDS = new AbstractCard[]{
            new InfluenceKnock(),
            new InfluenceHeart(),
            new FragmentSecretHistories().DoUpgrade(1),
            new Rumour(),
    };

    public TheTempleOfTheWheel() {
        super(ID, IMG_NAME, CARDS);
    }
}

