package TheSecretHistories.Content.Cards.Fragments;

import TheSecretHistories.Content.Powers.Principles.Grail;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.EDGE;
import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.LANTERN;

public class FragmentGrail extends AbstractFragment{

    public static String ID = StringUtils.MakeID(FragmentGrail.class.getSimpleName());

    public static CardTags PRINCIPLE_TAG = LANTERN;

    public FragmentGrail() {
        super(ID, PRINCIPLE_TAG);
    }
}
