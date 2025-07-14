package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.Spider;

import TheSecretHistories.Content.Cards.FITIF.Fragments.FragmentSecretHistories;
import TheSecretHistories.Content.Cards.FITIF.Influences.InfluenceForge;
import TheSecretHistories.Content.Cards.FITIF.Influences.InfluenceGrail;
import TheSecretHistories.Content.Cards.FITIF.Influences.InfluenceHeart;
import TheSecretHistories.Content.Cards.FITIF.Influences.InfluenceKnock;
import TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.AbstractMansusLocation;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.cards.AbstractCard;

public class TheSpiderDoor extends AbstractMansusLocation {

    public static final String ID = StringUtils.MakeID(TheSpiderDoor.class.getSimpleName());

    private static final String IMG_NAME = "waywhite";
    private static final AbstractCard[] CARDS = new AbstractCard[]{
            new InfluenceGrail().DoUpgrade(2),
            new InfluenceHeart().DoUpgrade(2),
            new FragmentSecretHistories().DoUpgrade(3),
            // 人情
    };

    public TheSpiderDoor() {
        super(ID, IMG_NAME, CARDS);
    }
}
