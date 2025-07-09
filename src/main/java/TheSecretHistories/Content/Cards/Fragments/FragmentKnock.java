package TheSecretHistories.Content.Cards.Fragments;

import TheSecretHistories.Content.Powers.Principles.Knock;
import TheSecretHistories.Content.Powers.Principles.Moth;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.KNOCK;
import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.LANTERN;

public class FragmentKnock extends AbstractFragment{

    public static String ID = StringUtils.MakeID(FragmentKnock.class.getSimpleName());

    public FragmentKnock() {
        super(ID, KNOCK);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        GainPrinciple(abstractPlayer, new Knock(abstractPlayer, magicNumber));
    }
}
