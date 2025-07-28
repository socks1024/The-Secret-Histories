package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.Spider;

import TheSecretHistories.Content.Cards.FITIF.Fragments.FragmentSecretHistories;
import TheSecretHistories.Content.Cards.FITIF.Influences.InfluenceGrail;
import TheSecretHistories.Content.Cards.FITIF.Influences.InfluenceHeart;
import TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.AbstractShowedLocation;
import TheSecretHistories.Content.Cards.Others.Favour;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.cards.AbstractCard;

public class TheSpiderDoor extends AbstractShowedLocation {

    public static final String ID = StringUtils.MakeID(TheSpiderDoor.class.getSimpleName());

    private static final String IMG_NAME = "wayspider";
    private static final AbstractCard[] CARDS = new AbstractCard[]{
            new InfluenceGrail().DoUpgrade(2),
            new InfluenceHeart().DoUpgrade(2),
            new FragmentSecretHistories().DoUpgrade(3),
            new Favour(),
    };

    public TheSpiderDoor() {
        super(ID, IMG_NAME, CARDS);
    }
}