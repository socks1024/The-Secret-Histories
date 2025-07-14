package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.White;

import TheSecretHistories.Content.Cards.FITIF.Fragments.FragmentSecretHistories;
import TheSecretHistories.Content.Cards.FITIF.Influences.InfluenceKnock;
import TheSecretHistories.Content.Cards.FITIF.Influences.InfluenceWinter;
import TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation.AbstractMansusLocation;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.cards.AbstractCard;

public class LodgeOfTheSageKnight extends AbstractMansusLocation {

    public static final String ID = StringUtils.MakeID(LodgeOfTheSageKnight.class.getSimpleName());

    private static final String IMG_NAME = "waywhite";
    private static final AbstractCard[] CARDS = new AbstractCard[]{
            new InfluenceKnock().DoUpgrade(1),
            new FragmentSecretHistories().DoUpgrade(2)
            // 灵感
            // 博闻
            // 入迷
            // 当局欠下的人情
    };

    public LodgeOfTheSageKnight() {
        super(ID, IMG_NAME, CARDS);
    }
}
