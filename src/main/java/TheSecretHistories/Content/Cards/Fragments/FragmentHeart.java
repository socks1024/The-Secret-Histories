package TheSecretHistories.Content.Cards.Fragments;

import TheSecretHistories.Content.Powers.Principles.Heart;
import TheSecretHistories.Content.Powers.Principles.Winter;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.HEART;
import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.LANTERN;

public class FragmentHeart extends AbstractFragment{

    public static String ID = StringUtils.MakeID(FragmentHeart.class.getSimpleName());

    public FragmentHeart() {
        super(ID, HEART);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        GainPrinciple(abstractPlayer, new Heart(abstractPlayer, magicNumber));
    }
}
