package TheSecretHistories.Content.Cards.Fragments;

import TheSecretHistories.Content.Powers.Principles.Moth;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.HEART;
import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.MOTH;

public class FragmentMoth extends AbstractFragment{

    public static String ID = StringUtils.MakeID(FragmentMoth.class.getSimpleName());

    public static CardTags PRINCIPLE_TAG = MOTH;

    public FragmentMoth() {
        super(ID, PRINCIPLE_TAG);
    }
}
