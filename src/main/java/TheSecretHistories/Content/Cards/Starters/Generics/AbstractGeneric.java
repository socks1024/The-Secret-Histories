package TheSecretHistories.Content.Cards.Starters.Generics;

import TheSecretHistories.Content.Cards.Template.TemplateCustomCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerColorEnum.CULT_BLUE;
import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.FOLLOWER;

public abstract class AbstractGeneric extends TemplateCustomCard {

    private static final int COST = 1;
    private static final CardColor COLOR = CULT_BLUE;
    private static final CardRarity RARITY = CardRarity.BASIC;

    public AbstractGeneric(String id, String img, CardType type, CardTarget target, CardTags principleTag) {
        super(id, img, COST, type, COLOR, RARITY, target);

        this.principleTag = principleTag;

        this.principleCount = this.basePrincipleCount = 2;

        this.tags.add(principleTag);
        this.tags.add(FOLLOWER);
    }

    @Override
    public void use(AbstractPlayer player, AbstractMonster monster) {
        PlayerGainPrinciple();
    }
}
