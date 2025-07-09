package TheSecretHistories.Content.Cards.Influences;

import TheSecretHistories.Content.Cards.Fragments.AbstractFragment;
import TheSecretHistories.Content.Powers.Principles.Edge;
import TheSecretHistories.Content.Powers.Principles.Forge;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.EDGE;
import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.FORGE;

public class InfluenceEdge extends AbstractFragment {

    public static String ID = StringUtils.MakeID(InfluenceEdge.class.getSimpleName());

    public InfluenceEdge() {
        super(ID, EDGE);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        GainPrinciple(abstractPlayer, new Edge(abstractPlayer, magicNumber));
    }
}
