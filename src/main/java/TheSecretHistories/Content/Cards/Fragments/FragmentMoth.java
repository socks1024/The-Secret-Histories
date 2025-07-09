package TheSecretHistories.Content.Cards.Fragments;

import TheSecretHistories.Content.Powers.Principles.Grail;
import TheSecretHistories.Content.Powers.Principles.Moth;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.LANTERN;
import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.MOTH;

public class FragmentMoth extends AbstractFragment{

    public static String ID = StringUtils.MakeID(FragmentMoth.class.getSimpleName());

    public FragmentMoth() {
        super(ID, MOTH);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        GainPrinciple(abstractPlayer, new Moth(abstractPlayer, magicNumber));
    }
}
