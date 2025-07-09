package TheSecretHistories.Content.Cards.Fragments;

import TheSecretHistories.Content.Powers.Principles.Knock;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.KNOCK;

public class FragmentKnock extends AbstractFragment{

    public static String ID = StringUtils.MakeID(FragmentKnock.class.getSimpleName());

    public FragmentKnock() {
        super(ID, KNOCK);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        PlayerGainPrinciple(abstractPlayer, new Knock(abstractPlayer, this.principleCount));
    }
}
