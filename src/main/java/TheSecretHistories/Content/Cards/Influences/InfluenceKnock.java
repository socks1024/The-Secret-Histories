package TheSecretHistories.Content.Cards.Influences;

import TheSecretHistories.Content.Cards.Fragments.AbstractFragment;
import TheSecretHistories.Content.Powers.Principles.Knock;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.KNOCK;

public class InfluenceKnock extends AbstractFragment {

    public static String ID = StringUtils.MakeID(InfluenceKnock.class.getSimpleName());

    public InfluenceKnock() {
        super(ID, KNOCK);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        PlayerGainPrinciple(abstractPlayer, new Knock(abstractPlayer, this.principleCount));
    }
}
