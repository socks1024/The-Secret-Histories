package TheSecretHistories.Content.Cards.Spirits;

import TheSecretHistories.Content.Cards.Template.TemplateCustomCard;
import TheSecretHistories.Utils.PrincipleUtils;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerColorEnum.CULT_BLUE;

public abstract class AbstractSpirit extends TemplateCustomCard {

    private static final CardColor COLOR = CULT_BLUE;
    private static final CardRarity RARITY = CardRarity.SPECIAL;

    private final PrincipleUtils.ReducePrincipleInfo[] infos;

    public AbstractSpirit(String id, String imgName, int cost, CardType type, CardTarget target, PrincipleUtils.ReducePrincipleInfo[] infos) {
        super(id, imgName, cost, type, COLOR, RARITY, target);

        this.infos = infos;
    }

    public PrincipleUtils.ReducePrincipleInfo[] GetInfos(){
        return infos;
    }

    public boolean GetAvailable() {
        return PrincipleUtils.PlayerHasEnoughPrinciple(infos);
    }
}
