package TheSecretHistories.Content.Cards.Fragments;

import TheSecretHistories.Content.Powers.Principles.Edge;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.EDGE;

public class FragmentEdge extends AbstractFragment{

    public static String ID = StringUtils.MakeID(FragmentEdge.class.getSimpleName());

    public FragmentEdge() {
        super(ID, EDGE);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        PlayerGainPrinciple(abstractPlayer, new Edge(abstractPlayer, this.principleCount));
    }
}
